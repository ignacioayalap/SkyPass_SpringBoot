package ayala.apiVuelos.controller;

import ayala.apiVuelos.entities.Base;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;

public interface BaseController<E extends Base, Id extends Serializable> {
    ResponseEntity<?> getAll();
    ResponseEntity<?> getAll(Pageable pageable);
    ResponseEntity<?> getOne(@PathVariable Id id);
    ResponseEntity<?> save(@RequestBody E entity);
    ResponseEntity<?> update(@PathVariable Id id, @RequestBody E entity);
    ResponseEntity<?> delete(@PathVariable Id id);
}
