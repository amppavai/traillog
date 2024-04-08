package hh.sof3.traillog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof3.traillog.domain.AninUser;
import hh.sof3.traillog.domain.AninUserRepository;
import hh.sof3.traillog.domain.Destination;
import hh.sof3.traillog.domain.DestinationRepository;
import hh.sof3.traillog.domain.FavoriteRepository;
import hh.sof3.traillog.domain.RatingRepository;

@SpringBootApplication
public class TraillogApplication {

	public static final Logger log = LoggerFactory.getLogger(TraillogApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TraillogApplication.class, args);
	}

	@Bean
	public CommandLineRunner traillog(AninUserRepository aninUserRepository, DestinationRepository destinationRepository, FavoriteRepository favoriteRepository, RatingRepository ratingRepository) {
		return (args) -> {
			log.info("Lisätää kohteita");
			Destination Marokko = destinationRepository.save(new Destination("Marokko", "Aavikkoa, rantaa ja vuoristoa"));
			Destination Suomi = destinationRepository.save(new Destination("Suomi", "Metsää, järvimaisemaa ja tuntureita"));
			Destination Italia = destinationRepository.save(new Destination("Italia", "Rantaa, vuoria ja historiaa"));
			Destination Ranska = destinationRepository.save(new Destination("Ranska", "Patonkia, juustoa ja viiniä"));

			log.info("Lisätään käyttäjiä");
			AninUser user1 = new AninUser("user", "user@user.com", "$2a$10$VSF6lLLBXj580kcIBMJJ..AYfmUy4/5.qh8.LloZckQvMNFipiSYy", "USER");
			AninUser user2 = new AninUser("admin", "admin@admin.com", "$2a$10$zL6n6Y1AUn/JXVZL/ILpMO0QwSJSl7Y831MIX65CnxzpPVvlNRusi", "ADMIN");
			aninUserRepository.save(user1);
			aninUserRepository.save(user2);

		};
	}
}
