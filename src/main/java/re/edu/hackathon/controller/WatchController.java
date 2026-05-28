package re.edu.hackathon.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import re.edu.hackathon.dto.request.WatchCreateDTO;
import re.edu.hackathon.dto.request.WatchPatchDTO;
import re.edu.hackathon.dto.request.WatchUpdateDTO;
import re.edu.hackathon.entity.Watch;
import re.edu.hackathon.service.WatchService;


@RestController
@RequestMapping("/api/v1/watches")
@RequiredArgsConstructor
public class WatchController {
    private final WatchService watchService;

    @GetMapping
    public ResponseEntity<?> getALl(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size, @RequestParam(required = false) String keyword){
        return watchService.getAll(page,size,keyword);
    }

    @PostMapping
    public ResponseEntity<?> createWatch(@Valid @RequestBody WatchCreateDTO dto){
        return watchService.create(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateWatch(@PathVariable Long id,@Valid @RequestBody WatchUpdateDTO dto){
        return watchService.update(id, dto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patchWatch(@PathVariable Long id,@Valid @RequestBody WatchPatchDTO dto){
        return watchService.patch(id, dto);
    }

    @DeleteMapping("/soft/{id}")
    public ResponseEntity<?> deleteSoft(@PathVariable Long id){
        return watchService.softDelete(id);
    }

    @DeleteMapping("/hard/{id}")
    public ResponseEntity<?> deleteHard(@PathVariable Long id){
        return watchService.hardDelete(id);
    }

}
