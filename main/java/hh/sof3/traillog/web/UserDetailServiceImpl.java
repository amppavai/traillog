package hh.sof3.traillog.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hh.sof3.traillog.domain.AninUser;
import hh.sof3.traillog.domain.AninUserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final AninUserRepository aninUserRepository;

    @Autowired
    public UserDetailServiceImpl(AninUserRepository aninUserRepository) {
        this.aninUserRepository = aninUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AninUser curruser = aninUserRepository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPasswordHash(),
                AuthorityUtils.createAuthorityList(curruser.getRole()));
        return user;
    }

}