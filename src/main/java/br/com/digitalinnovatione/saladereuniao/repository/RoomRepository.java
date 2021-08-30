package br.com.digitalinnovatione.saladereuniao.repository;

import br.com.digitalinnovatione.saladereuniao.model.Room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
