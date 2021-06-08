package com.chnu.pavel.telephone.service.province.interfaces;

import com.chnu.pavel.telephone.model.Province;
import com.chnu.pavel.telephone.service.GenericService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.ProvinceService
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 01.04.2021|01:18
 * @Version ProvinceService: 1.0
 */

@Service
public interface ProvinceService extends GenericService<Province> {

    Optional<Province> findByName(String name);
    Optional<Province> findByPhoneCode(String phoneCode);

}
