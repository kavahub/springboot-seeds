package com.springboot.seed.oauth2.operator;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/operators")
public class OperatorController {
    private final OperatorQueryService operatorQueryService;
    private final OperatorRepository operatorRepository;
    private final ModelMapper modelMapper;
    
    public OperatorController(OperatorQueryService operatorQueryService, OperatorRepository operatorRepository,
            ModelMapper modelMapper) {
        this.operatorQueryService = operatorQueryService;
        this.operatorRepository = operatorRepository;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<OperatorVO> save(@RequestBody OperatorVO vo) {
        Operator operator = operatorRepository.save(modelMapper.map(vo, Operator.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(operator, OperatorVO.class));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<OperatorVO> findById(@PathVariable String id) {
        return operatorRepository.findById(id)
            .map((e) -> modelMapper.map(e, OperatorVO.class))
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
            
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<OperatorVO> findByUsername(@PathVariable String username) {
        return operatorQueryService.findByUsername(username)
            .map((e) -> modelMapper.map(e, OperatorVO.class))
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @GetMapping(value = "/page")
    public Page<OperatorVO> getPage(@RequestParam(value = "nickname", required = false) String nickname,
            Pageable pageable) {
		Page<Operator> page = this.operatorQueryService.findByPage(nickname, pageable);
		return page.map(e -> modelMapper.map(e, OperatorVO.class));
	}   
}
