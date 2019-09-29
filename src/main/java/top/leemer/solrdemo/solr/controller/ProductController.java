package top.leemer.solrdemo.solr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import top.leemer.solrdemo.solr.model.Product;
import top.leemer.solrdemo.solr.service.ProductService;

import java.util.List;

/**
 * @author LEEMER
 * Create Date: 2019-09-15
 */
@RestController
@RequestMapping("/api/v1/solr/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //添加商品
    @PostMapping("/save")
    public Product save(){
        return productService.save();
    }

    //根据商品ID查询商品信息
    @GetMapping("/{id}")
    public Product findById(@PathVariable("id") Long id){
        return productService.findById(id);
    }

    //根据商品备注查询商品
    @GetMapping("/{remark}")
    public List<Product> findByRemark(@PathVariable("remark") String remark){
        return productService.findByRemark(remark);
    }

    //根据商品备注查询商品并分页
    @GetMapping("/page/{page}")
    public Page<Product> findByRemarkToPage(@PathVariable("page") int page){
        return productService.findByRemarkToPage("荣耀", page, 2);
    }

    //根据多个商品备注查询商品并分页
    @GetMapping("/page/or/{page}")
    public Page<Product> findByRemarkOrProductNameToPage(@PathVariable("page") int page){
        return productService.findByRemarkOrProductNameToPage("荣耀", "小辣椒", page, 2);
    }

}
