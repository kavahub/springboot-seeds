package com.springboot.seed.oauth2.operator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OperatorQueryServiceTests {
    @Autowired
    private OperatorRepository operatorRepository;
    @Autowired
    private OperatorQueryService operatorQueryService;

    private final static String USERNAME = "mock";

    @BeforeAll
    public void beforeEach() {
        operatorRepository.save(new Operator(USERNAME, "example", "example@qq.com"));
    }

    @Test
    public void giveWrongId_whenFindById_thenEntityNotFoundException(){
        assertThrows(EntityNotFoundException.class, () -> operatorQueryService.findById("wrongId"));
    }

    @Test
    public void giveNickname_whenFindByPage_thenOk() {
        Page<Operator> page = operatorQueryService.findByPage("examp", Pageable.ofSize(10));

        assertThat(page).isNotNull();
        assertThat(page.getTotalElements()).isEqualTo(1l);
        assertThat(page.getContent()).hasSize(1).extracting(Operator::getUsername).containsOnly(USERNAME.toUpperCase());
    }
}
