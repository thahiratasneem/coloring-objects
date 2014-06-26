package com.manish.sqlite;

public class Image {

	// private variables
	int _id;
//	String _name;
	byte[] _image;
	byte[] _uimage;

	// Empty constructor
	public Image() {

	}

	// constructor
	public Image(int keyId, byte[] image, byte[] uimage) {
		this._id = keyId;
		this._image = image;
		this._uimage = uimage;

	}

	// constructor
	public Image(String contactID, byte[] image, byte[] uimage) {
		this._image = image;
		this._uimage = uimage;

	}

	// constructor
	public Image(byte[] image, byte[] uimage) {
		this._image = image;
		this._uimage = uimage;
	}

	// getting ID
	public int getID() {
		return this._id;
	}

	// setting id
	public void setID(int keyId) {
		this._id = keyId;
	}

	// getting name
//	public String getName() {
//		return this._name;
//	}
//
//	// setting name
//	public void setName(String name) {
//		this._name = name;
//	}

	// getting phone number
	public byte[] getImage() {
		return this._image;
	}

	// setting phone number
	public void setImage(byte[] image) {
		this._image = image;
	}
	
	// getting phone number
		public byte[] getUImage() {
			return this._uimage;
		}

		// setting phone number
		public void setUImage(byte[] image) {
			this._uimage = image;
		}
}
