package com.example.ContactMicroserviceCompleteResponse.service;


import com.example.ContactMicroserviceCompleteResponse.model.Contact;
import com.example.ContactMicroserviceCompleteResponse.repository.IContactRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IContactServiceImpl implements IContactService {

    private final IContactRepo contactRepo;

    public IContactServiceImpl(IContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    @Override
    public boolean addContact(Contact contact) {
        if (contactRepo.findById(contact.getId()).isEmpty()) {
            contactRepo.save(contact);
            return true;
        }
        return false;
    }

    @Override
    public Contact showContact(String email) {
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return contactRepo.findByEmail(email);
    }

    @Override
    public void deleteContact(String email) {
        contactRepo.deleteByEmail(email);
    }

    @Override
    public List<Contact> findAll() {
        return contactRepo.findAll();
    }

    @Override
    public void deleteContact(int id) {
        contactRepo.deleteById(id);
    }

    @Override
    public Contact showContact(int id) {
        return contactRepo.findById(id).orElse(null);
    }

    @Override
    public void updateContact(Contact contact) {
        if (contactRepo.findById(contact.getId()).isPresent()) {
            contactRepo.save(contact);
        }

    }
}
