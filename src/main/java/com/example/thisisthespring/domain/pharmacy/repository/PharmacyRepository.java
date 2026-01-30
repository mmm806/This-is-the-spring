package com.example.thisisthespring.domain.pharmacy.repository;

import java.util.List;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.geo.Polygon;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.thisisthespring.domain.pharmacy.entity.Pharmacy;

public interface PharmacyRepository extends MongoRepository<Pharmacy, String> {
	List<Pharmacy> findByLocationNear(Point point, Distance distance);
	List<Pharmacy> findByLocationWithin(Polygon polygon);
}
