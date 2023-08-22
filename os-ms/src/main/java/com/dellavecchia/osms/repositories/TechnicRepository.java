package com.dellavecchia.osms.repositories;

import com.dellavecchia.osms.domain.Technic;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface TechnicRepository extends JpaRepository<Technic, Integer> {


}
