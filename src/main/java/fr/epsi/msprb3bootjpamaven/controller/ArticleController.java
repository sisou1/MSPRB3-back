package fr.epsi.msprb3bootjpamaven.controller;

import fr.epsi.msprb3bootjpamaven.bo.Article;
import fr.epsi.msprb3bootjpamaven.dal.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable Long id) {
        // Récupérer l'article par son ID depuis le repository
        Article article = articleRepository.findById(id).orElse(null);

        if (article != null) {
            // Retourner l'article avec le statut HTTP 200 OK
            return ResponseEntity.ok(article);
        } else {
            // Si l'article n'est pas trouvé, retourner le statut HTTP 404 Not Found
            return ResponseEntity.notFound().build();
        }
    }
}
