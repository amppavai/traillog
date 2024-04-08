package hh.sof3.traillog.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AninUserRepository extends JpaRepository <AninUser, Long> {
    AninUser findByUsername(String username);
    AninUser findByEmail(String email);

}