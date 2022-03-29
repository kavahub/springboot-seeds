package com.springboot.seed.oauth2.operator;

import com.springboot.seed.common.util.CommonRuntimeException;

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
            throw new CommonRuntimeException("手机号格式错误：" + phoneNumber);
        }

        final String email = needToSave.getEmail();
        if (StrUtil.isNotBlank(email) && !Validator.isEmail(email)) {
            throw new CommonRuntimeException("邮箱格式错误：" + phoneNumber);
        }

        return operatorRepository.save(needToSave);
    }
}
