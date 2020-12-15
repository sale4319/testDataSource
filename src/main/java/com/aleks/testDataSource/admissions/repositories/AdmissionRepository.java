package com.aleks.testDataSource.admissions.repositories;

import com.aleks.testDataSource.admissions.models.Admission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmissionRepository extends JpaRepository<Admission, Integer> {
}
