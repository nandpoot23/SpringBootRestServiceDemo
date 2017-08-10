package com.example.multiple.spring.rest.dao;

import com.example.multiple.spring.rest.types.EmpConfigIdentifier;
import com.example.multiple.spring.rest.types.EmpDetails;

/**
 * @author mlahariya
 * @version 1.0, Dec 2016
 */

public interface MultiDbService {

    public EmpDetails queryEmpConfigs(EmpConfigIdentifier id);

}
