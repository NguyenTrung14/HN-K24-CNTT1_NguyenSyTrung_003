package re.edu.hackathon.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import re.edu.hackathon.dto.request.WatchCreateDTO;
import re.edu.hackathon.dto.request.WatchPatchDTO;
import re.edu.hackathon.dto.request.WatchUpdateDTO;
import re.edu.hackathon.dto.response.WatchResponseDTO;
import re.edu.hackathon.entity.Watch;
import re.edu.hackathon.exception.CustomException;
import re.edu.hackathon.repository.WatchRepository;

@Service
@RequiredArgsConstructor
public class WatchServiceImpl implements WatchService{
    private  final WatchRepository watchRepository;

    @Override
    public ResponseEntity<?> create(WatchCreateDTO dto){
        Watch watch = Watch.builder()
                .modelName(dto.getModel_name())
                .brand(dto.getBrand())
                .price(dto.getPrice())
                .movementType(dto.getMovement_type())
                .status(dto.getStatus())
                .deleted(false)
                .build();
        Watch savedWatch = watchRepository.save(watch);
        return ResponseEntity.ok(WatchResponseDTO.fromEntity(savedWatch));
    }

    @Override
    public ResponseEntity<?> getAll(int page, int size, String keyword) {
        Pageable pageable = PageRequest.of(page,size);
        if(keyword == null || keyword.isEmpty()){
            return ResponseEntity.ok(watchRepository.findByDeletedFalse(pageable).map(WatchResponseDTO::fromEntity));
        }
        return ResponseEntity.ok(watchRepository.searchActiveByModelNameOrBrand(keyword,pageable).map(WatchResponseDTO::fromEntity));
    }

    private Watch findById(Long id){
        return watchRepository.findById(id).orElseThrow(()-> new CustomException("Khong tim thay watch", HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<?> update(Long id, WatchUpdateDTO dto) {
        Watch watch = findById(id);
        watch.setModelName(dto.getModel_name());
        watch.setBrand(dto.getBrand());
        watch.setPrice(dto.getPrice());
        watch.setMovementType(dto.getMovement_type());
        watch.setStatus(dto.getStatus());
        return ResponseEntity.ok(WatchResponseDTO.fromEntity(watchRepository.save(watch)));
    }

    @Override
    public ResponseEntity<?> patch(Long id, WatchPatchDTO dto) {
        Watch watch = findById(id);
        if(dto.getModel_name() !=null){
            watch.setModelName(dto.getModel_name());
        }
        if(dto.getBrand() != null){
            watch.setBrand(dto.getBrand());
        }
        if(dto.getPrice() != null){
            watch.setPrice(dto.getPrice());
        }
        if(dto.getMovement_type() != null){
            watch.setMovementType(dto.getMovement_type());
        }
        if(dto.getStatus() != null){
            watch.setStatus(dto.getStatus());
        }
        return ResponseEntity.ok(WatchResponseDTO.fromEntity(watchRepository.save(watch)));
    }

    @Override
    public ResponseEntity<?> softDelete(Long id) {
        Watch watch = findById(id);
        watch.setDeleted(true);
        watchRepository.save(watch);
        return ResponseEntity.ok("softDelete thanh cong");
    }

    @Override
    public ResponseEntity<?> hardDelete(Long id) {
        Watch watch = findById(id);
        watchRepository.delete(watch);
        return ResponseEntity.ok("hardDelete thanh cong");
    }


}
