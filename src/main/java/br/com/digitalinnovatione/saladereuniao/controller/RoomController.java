package br.com.digitalinnovatione.saladereuniao.controller;

import br.com.digitalinnovatione.saladereuniao.exception.ResourceNotFoundExecption;
import br.com.digitalinnovatione.saladereuniao.model.Room;
import br.com.digitalinnovatione.saladereuniao.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("rooms")
    public List<Room> gelAllRoom() {
        return roomRepository.findAll();
    }

    @GetMapping("rooms/{id}")
    public ResponseEntity<Room> getRoomId(@PathVariable(value = "id") long roomId)
            throws ResourceNotFoundExecption {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundExecption("Room not found: " + roomId));
        return ResponseEntity.ok().body(room);
    }

    @PostMapping("rooms")
    public Room createRoom(@Valid @RequestBody Room room) {
        return roomRepository.save(room);
    }
    @PutMapping("rooms/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable(value = "id") Long roomId,
                                           @Valid @RequestBody Room roomDetails) throws ResourceNotFoundExecption{
        Room room = roomRepository.findById(roomId)
                .orElseThrow(()->new ResourceNotFoundExecption("Room not found this id:"+roomId));
        room.setName(roomDetails.getName());
        room.setDate(roomDetails.getDate());
        room.setStarHour(roomDetails.getStarHour());
        room.setEndHour(roomDetails.getEndHour());

        final Room updateRoom = roomRepository.save(room);
        return ResponseEntity.ok(updateRoom);
    }

    public Map<String, Boolean>deleteRoom(@PathVariable(value = "id") long roomId)
            throws ResourceNotFoundExecption{
        Room room = roomRepository.findById(roomId).
                orElseThrow(()-> new ResourceNotFoundExecption("Room not found this id:"+roomId));
        roomRepository.delete(room);
        Map<String, Boolean> response  = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    }
}
