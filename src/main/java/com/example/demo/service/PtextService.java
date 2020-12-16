package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.ptext.Ptext;
import com.example.demo.domain.ptext.PtextRepository;
import com.example.demo.web.dto.PtextListResponseDto;
import com.example.demo.web.dto.PtextResponseDto;
import com.example.demo.web.dto.PtextSaveRequestDto;
import com.example.demo.web.dto.PtextUpdateRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PtextService {
    private final PtextRepository ptextRepossitory;

    @Transactional
    public Long save(PtextSaveRequestDto requestDto) {
        return ptextRepossitory.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PtextUpdateRequestDto requestDto) {
        Ptext ptexts = ptextRepossitory.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        ptexts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional
    public void delete (Long id) {
        Ptext ptexts = ptextRepossitory.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        ptextRepossitory.delete(ptexts);
    }

    @Transactional(readOnly = true)
    public PtextResponseDto findById(Long id) {
        Ptext entity = ptextRepossitory.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new PtextResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PtextListResponseDto> findAllDesc() {
        return ptextRepossitory.findAllDesc().stream()
                .map(PtextListResponseDto::new)
                .collect(Collectors.toList());
    }
}