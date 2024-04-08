package hh.sof3.traillog.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Rating {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ratingid;
    private Integer starRating;
    private String ratingText;

    @ManyToOne
    @JsonIgnoreProperties("ratings")
    @JoinColumn(name = "destid")
    private Destination destination;

    public Rating() {
    }

    public Rating(Integer starRating, String ratingText) {
        this.starRating = starRating;
        this.ratingText = ratingText;
    }

    public Long getRatingid() {
        return ratingid;
    }

    public void setRatingid(Long ratingid) {
        this.ratingid = ratingid;
    }

    public Integer getStarRating() {
        return starRating;
    }

    public void setStarRating(Integer starRating) {
        this.starRating = starRating;
    }

    public String getRatingText() {
        return ratingText;
    }

    public void setRatingText(String ratingText) {
        this.ratingText = ratingText;
    }

    
}
