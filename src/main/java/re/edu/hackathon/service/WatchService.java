package re.edu.hackathon.service;


import org.springframework.http.ResponseEntity;
import re.edu.hackathon.dto.request.WatchCreateDTO;
import re.edu.hackathon.dto.request.WatchPatchDTO;
import re.edu.hackathon.dto.request.WatchUpdateDTO;
import re.edu.hackathon.entity.Watch;

public interface WatchService {
    ResponseEntity<?> create(WatchCreateDTO watch);
    ResponseEntity<?> getAll(int page, int size, String keyword);
    ResponseEntity<?> update(Long id, WatchUpdateDTO watch);
    ResponseEntity<?> patch(Long id, WatchPatchDTO watch);
    ResponseEntity<?> softDelete(Long id);
    ResponseEntity<?> hardDelete(Long id);

}
