package com.bbb.songeoreum.oauth.service;

import com.bbb.songeoreum.db.domain.User;
import com.bbb.songeoreum.db.repository.UserRepository;
import com.bbb.songeoreum.exception.UserNotFoundException;
import com.bbb.songeoreum.oauth.entity.PrincipalDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipal;

// security 설정에서 loginProcessingUrl("/login");
// "/login" 요청이 오면 자동으로 UserDetailService 타입으로 IoC되어 있는 loadUserByUsername 함수가 실행
@Slf4j
@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.debug("loadUserByUsername 호출, 넘어온 username : {}", username);

        User user = userRepository.findByNickname(username).orElseThrow(() -> new UserNotFoundException());

        // user가 null이 아닌 경우
//        return new PrincipalDetails(user)
        return PrincipalDetails.create(user);
    }
}