package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TurnService {

    @Autowired
    private TurnRepository turnRepository;

    public Turn save(Turn turn){
        return turnRepository.save(turn);
    }
}
