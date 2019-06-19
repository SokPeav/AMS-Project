package com.example.demo.Controller;

import com.example.demo.model.Article;
import com.example.demo.model.Category;
import com.example.demo.model.Filter;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
public class CategoryController {

    private CategoryService categoryService;


    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category")
    public String showCategory( Model m)
    {
        List<Category> categories = categoryService.findall();
            m.addAttribute("categories",categories);
            return "/category";
    }

    @GetMapping("/remove/{id}")
    public String deleteCategory(@PathVariable Integer id)
    {
        System.out.println("HI");
        categoryService.delete(id);
        return "redirect:/category";
    }

    @GetMapping("/upgrade/{id}")
    public String updateCategory(ModelMap m,@PathVariable Integer id){
        m.addAttribute("categories", categoryService.findById(id));
        return "upgradeCategory";

    }

    @RequestMapping(value = "/upgrades", method = RequestMethod.POST)
    public String saveUpgrade(@ModelAttribute  Category category)
    {
        System.out.println("Hellosadasda");
        categoryService.update(category);
        return "redirect:upgrade/" + category.getCate_id();
    }


    @GetMapping("/addCategory")
    public String addCategory(ModelMap m) {
        m.addAttribute("categories", new Category());
        System.out.println("ppppp");
        return "addCategory";
    }


    @PostMapping("/addCategory")
    public String saveAdd(@Valid @ModelAttribute Category category , BindingResult result,Model m)
    {
        if (result.hasErrors()) {
            m.addAttribute("categories", category);
            System.out.println("Hi");
            return "/addCategory";
        }
         categoryService.add(category);
        return "redirect:/category";
    }


}
