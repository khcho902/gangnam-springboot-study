package com.khcho902.gangnamspringbootstudy.service;

import com.khcho902.gangnamspringbootstudy.dto.BlogDTO;
import com.khcho902.gangnamspringbootstudy.repository.BlogRepository;
import com.khcho902.gangnamspringbootstudy.dto.ResponseBlog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;

    public List<BlogDTO> findByQuery(String query) {
        return blogRepository.findByQuery(query).getItems().stream()
                .map(b -> BlogDTO.builder()
                        .title(b.getTitle())
                        .link(b.getLink())
                        .description(b.getDescription())
                        .bloggername(b.getBloggername())
                        .bloggerlink(b.getBloggerlink())
                        .postdate(b.getPostdate())
                        .build()
                ).collect(Collectors.toList());
    }
}