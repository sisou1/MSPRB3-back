package fr.epsi.msprb3bootjpamaven.bo;

import fr.epsi.msprb3bootjpamaven.Msprb3BootjpaMavenApplication;
import jakarta.persistence.*;
import org.springframework.boot.SpringApplication;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "plantes")
public class Plante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "is_needing_care")
    private boolean isNeedingCare;

    @Column(name = "is_needing_tips")
    private boolean isNeedingTips;

    @Column(name = "coordinate")
    private String coordinate;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "ville")
    private String ville;

    @Column(name = "adresse")
    private String adresse;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToMany
    @JoinTable(
            name = "plante_topic",
            joinColumns = @JoinColumn(name = "plante_id"),
            inverseJoinColumns = @JoinColumn(name = "topic_id")
    )
    private List<Topic> topics;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    @OneToMany(mappedBy = "plante")
    private List<Image> images;


    // Constructeurs, getters et setters
    public Plante() {}

    // Getters et Setters pour chaque attribut
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isNeedingCare() {
        return isNeedingCare;
    }

    public void setNeedingCare(boolean needingCare) {
        isNeedingCare = needingCare;
    }

    public boolean isNeedingTips() {
        return isNeedingTips;
    }

    public void setNeedingTips(boolean needingTips) {
        isNeedingTips = needingTips;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public static void main(String[] args) {
        SpringApplication.run(Msprb3BootjpaMavenApplication.class, args);
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

}
