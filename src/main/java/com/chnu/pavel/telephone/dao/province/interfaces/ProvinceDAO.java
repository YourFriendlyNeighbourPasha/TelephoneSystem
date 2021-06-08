package com.chnu.pavel.telephone.dao.province.interfaces;

import com.chnu.pavel.telephone.dao.GenericDAO;
import com.chnu.pavel.telephone.model.Province;
import com.chnu.pavel.telephone.model.State;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.ProvinceDAO
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 01.04.2021|01:15
 * @Version ProvinceDAO: 1.0
 */

@Repository
public interface ProvinceDAO extends GenericDAO<Province> {

    Optional<Province> findByName(String name);
    Optional<Province> findByPhoneCode(String phoneCode);

}
