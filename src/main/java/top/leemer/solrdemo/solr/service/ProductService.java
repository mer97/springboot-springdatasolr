package top.leemer.solrdemo.solr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.solr.core.SolrOperations;
import org.springframework.stereotype.Service;
import top.leemer.solrdemo.solr.model.Product;
import top.leemer.solrdemo.solr.repository.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author LEEMER
 * Create Date: 2019-09-15
 */
@Service
public class ProductService {

    @Autowired
    private SolrOperations solrOperations;

    @Autowired
    private ProductRepository productRepository;

    public Product save(){
        Product product = new Product();
        product.setId(Long.valueOf(UUID.randomUUID().toString().hashCode()));
        product.setProductName("316柔雾小辣椒");
        product.setCategory("化妆品");
        product.setSellingPrice(170.00);
        product.setRemark("魅可丝缎柔雾唇膏");

        productRepository.save(product);
        return product;
    }

    public Product findById(Long id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()){
            return optionalProduct.get();
        }
        return null;
    }

    public List<Product> findByRemark(String remark) {
        return productRepository.findByRemark(remark);
    }

    public Page<Product> findByRemarkToPage(String remark, int page, int size) {
        if (page < 0) page = 0;
        PageRequest pageRequest = PageRequest.of(page, size, new Sort(Sort.Direction.DESC, "id"));
        return productRepository.findByRemark(remark, pageRequest);
    }

    public Page<Product> findByRemarkOrProductNameToPage(String remark, String productName, int page, int size) {
        if (page < 0) page = 0;
        PageRequest pageRequest = PageRequest.of(page, size, new Sort(Sort.Direction.DESC, "id"));
        return productRepository.findByRemarkOrProductName(remark, productName, pageRequest);
    }
}
