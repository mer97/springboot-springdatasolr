package top.leemer.solrdemo.solr.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;
import top.leemer.solrdemo.solr.model.Product;

import java.util.List;

/**
 * @author LEEMER
 * Create Date: 2019-09-15
 */
@Repository
public interface ProductRepository extends SolrCrudRepository<Product, Long> {
    List<Product> findByRemark(String remark);

    Page<Product> findByRemark(String remark, Pageable pageable);

    Page<Product> findByRemarkOrProductName(String remark, String productName, Pageable pageable);
}
