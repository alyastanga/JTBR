CREATE TABLE IF NOT EXISTS users (
    _user_id INTEGER PRIMARY KEY,
    username TEXT UNIQUE NOT NULL,
    password_hash TEXT NOT NULL,
    full_name TEXT NOT NULL,
    role TEXT NOT NULL CHECK (role IN ('admin', 'employee')),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    is_active BOOLEAN NOT NULL DEFAULT 1
);

CREATE TABLE IF NOT EXISTS suppliers (
    _supplier_id INTEGER PRIMARY KEY,
    company_name TEXT NOT NULL,
    contact_person TEXT,
    phone TEXT,
    email TEXT,
    address TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    is_active BOOLEAN NOT NULL DEFAULT 1
);

CREATE TABLE IF NOT EXISTS raw_materials (
    _raw_material_id INTEGER PRIMARY KEY,
    material_name TEXT NOT NULL,
    description TEXT,
    quantity INTEGER NOT NULL DEFAULT 0,
    unit TEXT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    is_deleted BOOLEAN DEFAULT 0
);

CREATE TABLE IF NOT EXISTS raw_materials_orders (
    _order_id INTEGER PRIMARY KEY,
    _supplier_id INTEGER,
    _employee_id INTEGER,
    _created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    _order_number TEXT UNIQUE NOT NULL DEFAULT (hex(randomblob(16))),
    discount_type TEXT NOT NULL CHECK (discount_type IN ('none', 'fixed', 'percent')),
    discount_value_php REAL NOT NULL DEFAULT 0.00,
    vat_percent REAL NOT NULL DEFAULT 12.00,
    status TEXT NOT NULL CHECK (status IN ('pending', 'acknowledged', 'rejected', 'cancelled', 'audited')),
    status_updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    remarks TEXT,
    FOREIGN KEY (_supplier_id) REFERENCES suppliers(_supplier_id) ON DELETE CASCADE,
    FOREIGN KEY (_employee_id) REFERENCES users(_user_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS order_payments (
    _order_payment_id INTEGER PRIMARY KEY,
    _order_id INTEGER,
    _created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    reference_number TEXT,
    payment_method TEXT NOT NULL CHECK (payment_method IN ('cash', 'gcash', 'bank_transfer', 'credit_card')),
    amount_php REAL NOT NULL CHECK (amount_php > 0),
    FOREIGN KEY (_order_id) REFERENCES raw_materials_orders(_order_id) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS attendance (
    _attendance_id INTEGER PRIMARY KEY,
    _user_id INTEGER,
    check_in TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    check_out TIMESTAMP,
    FOREIGN KEY (_user_id) REFERENCES users(_user_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS items (
    _item_id INTEGER PRIMARY KEY,
    item_name TEXT NOT NULL,
    description TEXT,
    category TEXT,
    unit TEXT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    is_deleted BOOLEAN DEFAULT 0
);

CREATE TABLE IF NOT EXISTS contracts (
    _contract_id INTEGER PRIMARY KEY,
    customer_name TEXT NOT NULL,
    contact_number TEXT,
    address TEXT,
    type_of_service TEXT NOT NULL CHECK (type_of_service IN ('repair', 'installation')),
    status TEXT NOT NULL CHECK (status IN ('in_progress', 'completed', 'picked_up')),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS contract_details (
    _contract_id INTEGER,
    _item_id INTEGER,
    quantity INTEGER NOT NULL CHECK (quantity > 0),
    size TEXT,
    unit_price REAL NOT NULL CHECK (unit_price >= 0),
    FOREIGN KEY (_contract_id) REFERENCES contracts(_contract_id) ON DELETE CASCADE,
    FOREIGN KEY (_item_id) REFERENCES items(_item_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS sales (
    _contract_id INTEGER,
    sale_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    total_amount REAL NOT NULL CHECK (total_amount >= 0),
    FOREIGN KEY (_contract_id) REFERENCES contracts(_contract_id) ON DELETE CASCADE
);
