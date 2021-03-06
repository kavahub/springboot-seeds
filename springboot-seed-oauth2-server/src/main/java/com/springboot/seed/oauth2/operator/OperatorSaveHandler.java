package com.springboot.seed.oauth2.operator;

import org.springframework.stereotype.Service;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;

@Service
public class OperatorSaveHandler {
    private final OperatorRepository operatorRepository;

    public OperatorSaveHandler(OperatorRepository operatorRepository) {
        this.operatorRepository = operatorRepository;
    }

    public Operator save(final Operator needToSave) {
        final String phoneNumber = needToSave.getPhoneNumber();
        if (StrUtil.isNotBlank(phoneNumber) && !Validator.isMobile(phoneNumber)) {
            throw new PhoneNumberValidateExcepiton(phoneNumber);
        }

        final String email = needToSave.getEmail();
        if (StrUtil.isNotBlank(email) && !Validator.isEmail(email)) {
            throw new EmailValidateExcepiton(email);
        }

        return operatorRepository.save(needToSave);
    }
}
