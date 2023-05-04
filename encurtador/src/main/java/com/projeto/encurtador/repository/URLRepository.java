package com.projeto.encurtador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.encurtador.entity.URL;

public interface URLRepository extends JpaRepository<URL, Integer>{

}
