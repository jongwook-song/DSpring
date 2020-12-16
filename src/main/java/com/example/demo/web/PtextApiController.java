package com.example.demo.web;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.PtextService;
import com.example.demo.web.dto.PtextListResponseDto;
import com.example.demo.web.dto.PtextResponseDto;
import com.example.demo.web.dto.PtextSaveRequestDto;
import com.example.demo.web.dto.PtextUpdateRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PtextApiController {

    private final PtextService ptextService;

    @PostMapping("/api/v1/ptexts")
    public Long save(@RequestBody PtextSaveRequestDto requestDto) {
        return ptextService.save(requestDto);
    }

    @PutMapping("/api/v1/ptexts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PtextUpdateRequestDto requestDto) {
        return ptextService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/ptexts/{id}")
    public Long delete(@PathVariable Long id) {
        ptextService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/ptexts/{id}")
    public PtextResponseDto findById(@PathVariable Long id) {
        return ptextService.findById(id);
    }

    @GetMapping("/api/v1/ptexts/list")
    public List<PtextListResponseDto> findAll() {
        return ptextService.findAllDesc();
    }
}