package com.example.ContactMicroserviceCompleteResponse.controller;


import com.example.ContactMicroserviceCompleteResponse.model.Contact;
import com.example.ContactMicroserviceCompleteResponse.service.IContactService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {

    private final IContactService contactService;

    public ContactController(IContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping(value = "contacts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Contact>>  show(){
        List<Contact> contacts = contactService.findAll();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("total", String.valueOf(contacts.size()));
        return new ResponseEntity<List<Contact>>(contacts, httpHeaders, HttpStatus.OK);
    }

    @GetMapping(value = "contacts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Contact> show(@PathVariable(name = "id") int id){
        return new ResponseEntity<Contact>(contactService.showContact(id), HttpStatus.OK);
    }

    @PostMapping(value = "contacts", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addContact(@RequestBody Contact contact){
        if(contactService.addContact(contact)){
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else{
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping(value = "contacts", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> update(@RequestBody Contact contact){
        contactService.updateContact(contact);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "contacts/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(name = "id") int id){
        contactService.deleteContact(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
