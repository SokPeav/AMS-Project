package com.example.demo.Controller;

import com.example.demo.Utility.Paging;
import com.example.demo.model.Article;

import com.example.demo.model.Filter;
import com.example.demo.service.ArticleService;
import com.example.demo.service.CategoryService;
import groovy.cli.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Controller
@PropertySource("classpath:ams.properties")
public class HomeController {

    private ArticleService articleService;

    private CategoryService categoryService;

    @Autowired
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("/")
    public String Home(Filter filter, Paging paging, Model m) {
//        System.out.println(filter);
        List<Article> articles = articleService.findAllFilter(filter,paging);
        m.addAttribute("categories", categoryService.findall());
        m.addAttribute("articles", articles);
        m.addAttribute("filter", filter);
        m.addAttribute("paging",paging);

        return "index";
    }

    @GetMapping("/add")
    public String add(ModelMap m) {
        m.addAttribute("article", new Article());
        m.addAttribute("categories", categoryService.findall());
        return "add";
    }

    @PostMapping("/add")
    public String insert(@Valid @ModelAttribute Article article, BindingResult result, Model m, MultipartFile file) {
        if (result.hasErrors()) {
            m.addAttribute("article", article);
            System.out.println("Hello");
            m.addAttribute("categories", categoryService.findall());
            return "add";
        }
        if (!file.isEmpty()) {
            System.out.println(file.getOriginalFilename());
            String nameFile = UUID.randomUUID().toString() + file.getOriginalFilename();
            try {
                Files.copy(file.getInputStream(), Paths.get(System.getProperty("user.dir") + "/src/main/resources/images/", nameFile));
                System.out.println("asdasdasd");

                article.setImage(nameFile);
                System.out.println(nameFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        article.setCategory(categoryService.findById(article.getCategory().getCate_id()));
        articleService.add(article);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        articleService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String update(ModelMap m, @PathVariable Integer id) {
        m.addAttribute("categories", categoryService.findall());
        m.addAttribute("article", articleService.findById(id));
        System.out.println("Getting Article");
        return "update";
    }

    @RequestMapping(value = "/updates", method = RequestMethod.POST)
    public String saveUpdate(@ModelAttribute Article article, MultipartFile file) {
        System.out.println("PostMapping : Update");
        System.out.println(article.toString());
        if (!file.isEmpty()) {
            System.out.println(file.getOriginalFilename());
            String nameFile = UUID.randomUUID().toString() + file.getOriginalFilename();
            try {
                Files.copy(file.getInputStream(), Paths.get(System.getProperty("user.dir") + "/src/main/resources/images/", nameFile));
                System.out.println("asdasdasd");

                article.setImage(nameFile);
                System.out.println(nameFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        articleService.update(article);
        return "redirect:update/" + article.getId();
    }

    @GetMapping("/detail/{id}")
    public String Detail(ModelMap m, @PathVariable Integer id) {
//        m.addAttribute("isAdd", false);
        Article article = articleService.findById(id);
        System.out.println(article.toString());
        m.addAttribute("article", article);
        System.out.println("Getting Article");
        return "detail";
    }

    @GetMapping("/search")
    public String search(@RequestParam(value = "search", required = false, defaultValue = "a") Filter filter, Model m) {
        List<Article> articles = articleService.search(filter);
        m.addAttribute("articles", articles);
        return "index";
    }

}

