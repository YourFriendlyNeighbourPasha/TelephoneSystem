package com.chnu.pavel.telephone.service.availablephonenumber.impls;

import com.chnu.pavel.telephone.dao.availablephonenumber.interfaces.AvailablePhoneNumberDAO;
import com.chnu.pavel.telephone.model.AvailablePhoneNumber;
import com.chnu.pavel.telephone.service.availablephonenumber.interfaces.AvailablePhoneNumberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.time.Instant;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * TelephoneSystem.AvailablePhoneNumberServiceImpl
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 06.06.2021|18:01
 * @Version AvailablePhoneNumberServiceImpl: 1.0
 */

@Component
@RequiredArgsConstructor
public class AvailablePhoneNumberServiceImpl implements AvailablePhoneNumberService {

    private final AvailablePhoneNumberDAO dao;

    @Override
    public AvailablePhoneNumber findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public AvailablePhoneNumber updateById(Long id, AvailablePhoneNumber entityObj) {
        entityObj.setModified_at(Date.from(Instant.now()));
        return dao.updateById(id, entityObj);
    }

    @Override
    public AvailablePhoneNumber create(AvailablePhoneNumber entityObj) {
        entityObj.setCreated_at(Date.from(Instant.now()));
        entityObj.setModified_at(Date.from(Instant.now()));
        return dao.create(entityObj);
    }

    @Override
    public AvailablePhoneNumber deleteById(Long id) {
        return dao.deleteById(id);

    }

    @Override
    public List<AvailablePhoneNumber> findAll() {
        return dao.findAll();
    }
}