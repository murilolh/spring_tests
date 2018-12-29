package com.spring.tests.contactservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.tests.contactservices.model.Contact;

public interface ContactDao extends JpaRepository<Contact, Long> {

}
