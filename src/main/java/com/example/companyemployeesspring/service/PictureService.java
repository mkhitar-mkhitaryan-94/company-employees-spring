package com.example.companyemployeesspring.service;

import com.example.companyemployeesspring.repository.PictureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PictureService {

    private final PictureRepository pictureRepository;


}
