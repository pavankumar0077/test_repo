package com.olx.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.olx.dto.Advertise;

@Service
public class AdvertiseServiceImpl implements AdvertiseService {

	@Override
	public Advertise postAdvertise(Advertise adv) {
		return null;
	}

	@Override
	public Advertise updateAdvertise(Advertise adv) {
		return null;
	}
	

	@Override
	public List<Advertise> getAllAdvByUser() {
		return null;
	}

	@Override
	public List<Advertise> getAdvByUser() {
		return null;
	}

//	@Override
//	public Advertise filterAdv(Advertise adv) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public List<Advertise> searchAdvertisesByFilterCriteria(String searchText, int categoryId, String postedBy,
			String dateCondition, LocalDate onDate, LocalDate fromDate, LocalDate toDate, String sortedBy,
			int startIndex, int records) {
		return null;
	}

	@Override
	public Advertise returnAdv(int id) {
		return null;
	}

	@Override
	public Advertise SearchAdvByText(String searchText) {
		return null;
	}

	@Override
	public boolean deleteAdvertise(Advertise adv) {
		return true;
	}
	

	
	

	

}
