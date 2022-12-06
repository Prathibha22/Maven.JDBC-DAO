package models;

public class DTOCar {
        //fields
        private Integer _id;
        private String _name;
        private String _make;
        private String _year;
        private String _color;
        //Constructors
        public DTOCar() {
        }

        public DTOCar(String _name, String _make, String _year, String _color) {
            this._name = _name;
            this._make = _make;
            this._year = _year;
            this._color = _color;
        }

        public DTOCar(int _id, String _name, String _make, String _year, String _color) {
            this._id = _id;
            this._name = _name;
            this._make = _make;
            this._year = _year;
            this._color = _color;
        }
        //getters and setters


        public int get_id() {
            return _id;
        }
        public void set_id(int id){this._id=id;} //created for test method

        public String get_name() {
            return _name;
        }

        public void set_name(String _name) {
            this._name = _name;
        }

        public String get_make() {
            return _make;
        }

        public void set_make(String _make) {
            this._make = _make;
        }

        public String get_year() {
            return _year;
        }

        public void set_year(String _year) {
            this._year = _year;
        }

        public String get_color() {
            return _color;
        }

        public void set_color(String _color) {
            this._color = _color;
        }


}
