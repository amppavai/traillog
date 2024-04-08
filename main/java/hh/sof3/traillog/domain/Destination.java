package hh.sof3.traillog.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long destid;
    private String destName;
    private String destDescription;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "destination")
    @JsonIgnoreProperties ("destination")
    private List<AninUser> users;

    public Destination() {}

    public Destination(String destName, String destDescription) {
        this.destName = destName;
        this.destDescription = destDescription;
    }

    public Long getdestid() {
        return destid;
    }

    public void setdestid(Long destid) {
        this.destid = destid;
    }

    public String getdestName() {
        return destName;
    }

    public void setdestName(String destName) {
        this.destName = destName;
    }

    public String getdestDescription() {
        return destDescription;
    }

    public void setdestDescription(String destDescription) {
        this.destDescription = destDescription;
    }

    
}
