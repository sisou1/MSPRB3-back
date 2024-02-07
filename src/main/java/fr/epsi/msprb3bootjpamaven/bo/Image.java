package fr.epsi.msprb3bootjpamaven.bo;

import jakarta.persistence.*;

@Entity
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name = "img")
    private byte[] img;

    @ManyToOne
    @JoinColumn(name = "id_plante")
    private Plante plante;

    @ManyToOne
    @JoinColumn(name = "id_article")
    private Article article;

    // Constructeurs, getters et setters
    public Image() {}

    // Getters et Setters pour chaque attribut
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public Plante getPlante() {
        return plante;
    }

    public void setPlante(Plante plante) {
        this.plante = plante;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
