package com.bnpparibas.itg.mylibraries.libraries.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryDAO extends JpaRepository<LibraryJPA,Long> {}
