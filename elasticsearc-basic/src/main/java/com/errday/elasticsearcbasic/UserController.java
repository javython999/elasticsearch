package com.errday.elasticsearcbasic;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserDocumentRepository userDocumentRepository;

    @PostMapping()
    public UserDocument createUser(@RequestBody UserCreateRequestDto requestDto) {
        UserDocument user = new UserDocument(
                requestDto.getId(),
                requestDto.getName(),
                requestDto.getAge(),
                requestDto.getIsActive()
        );

        return userDocumentRepository.save(user);
    }

    @GetMapping()
    public Page<UserDocument> findUsers() {
        return userDocumentRepository.findAll(PageRequest.of(0, 10));
    }

    @GetMapping("/{id}")
    public UserDocument findUserById(@PathVariable String id) {
        return userDocumentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 사용자입니다."));
    }

    @PutMapping("/{id}")
    public UserDocument updateUser(@PathVariable String id, @RequestBody UserUpdateRequestDto requestDto) {
        UserDocument existingUser = userDocumentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 사용자입니다."));

        existingUser.setName(requestDto.getName());
        existingUser.setAge(requestDto.getAge());
        existingUser.setIsActive(requestDto.getIsActive());

        return userDocumentRepository.save(existingUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable String id) {
        UserDocument existingUser = userDocumentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 사용자입니다."));

        userDocumentRepository.delete(existingUser);
    }
}
