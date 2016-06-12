
package ua.sasa.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author sasav
 */
@Entity
@Table(name = "Images")
public class Image implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private long id;
    
    private String name;
    
    private String description;
    
    private LocalDateTime  dateCreation;
    
    private String filePath;

    public Image() {
    }

    public Image(String name, String description, LocalDateTime dateCreation, String filePath) {
        this.name = name;
        this.description = description;
        this.dateCreation = dateCreation;
        this.filePath = filePath;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
 
}
