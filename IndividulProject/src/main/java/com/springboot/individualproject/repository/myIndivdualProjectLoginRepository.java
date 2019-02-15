package com.springboot.individualproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.springboot.individualproject.model.myIndivdualProjectLoginModel;



@Repository
public interface myIndivdualProjectLoginRepository extends JpaRepository<myIndivdualProjectLoginModel,Long>  {

}