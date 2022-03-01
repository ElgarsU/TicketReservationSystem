package user;

import org.springframework.data.jpa.repository.JpaRepository;
import ticket.Ticket;

public interface UserRepository extends JpaRepository<Ticket, Long> {
}
