package com.filterdemo.repository;

import com.filterdemo.entity.LanguageMapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageMappingRepository extends JpaRepository<LanguageMapping, Long> {

}
