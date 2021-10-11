package com.psl.springdata.files.repos;

import org.springframework.data.repository.CrudRepository;

import com.psl.springdata.files.entities.Image;

public interface ImageRepository extends CrudRepository<Image, Long> {

}
