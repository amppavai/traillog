package hh.sof3.traillog.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long favid;
    private boolean isFavorite;

    @ManyToOne
    @JsonIgnoreProperties("favorites")
    @JoinColumn(name = "userid")
    private AninUser user;

    public Favorite() {
    }

    public Favorite(Long favid, boolean isFavorite) {
        this.favid = favid;
        this.isFavorite = isFavorite;
    }

    public Long getfavid() {
        return favid;
    }

    public void setfavid(Long favid) {
        this.favid = favid;
    }

    public boolean getisFavorite() {
        return isFavorite;
    }

    public void setisFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

}
