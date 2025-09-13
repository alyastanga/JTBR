PRAGMA foreign_keys = ON;


INSERT OR IGNORE INTO users (_user_id, username, password_hash, full_name, role, created_at, is_active) VALUES
(1, 'admin_peter', 'hash_admin_123', 'Peter M. Dela Cruz', 'admin', '2025-08-01 09:00:00', 1),
(2, 'alejandro',    'hash_emp_001',  'Alejandro Santos',        'employee', '2025-07-15 08:30:00', 1),
(3, 'marie_c',      'hash_emp_002',  'Marie Cruz',              'employee', '2025-06-20 10:15:00', 1),
(4, 'juan_d',       'hash_emp_003',  'Juan Dela Rosa',          'employee', '2025-05-12 07:45:00', 1),
(5, 'liza_b',       'hash_emp_004',  'Liza Bernardo',           'employee', '2025-04-02 08:00:00', 1),
(6, 'ronald_k',     'hash_emp_005',  'Ronald Katigbak',         'employee', '2025-03-22 09:30:00', 1);

INSERT OR IGNORE INTO suppliers (_supplier_id, company_name, contact_person, phone, email, address, created_at, is_active) VALUES
(1, 'PhilGlass Trading', 'Ramon Dela Torre', '+63-2-8111-0101', 'sales@philglass.ph', 'Blk 3 Lot 12, Valenzuela City', '2025-07-01 09:00:00', 1),
(2, 'Tempered Solutions', 'Lucia Mendoza', '+63-2-8111-0202', 'orders@tempersol.ph', 'Unit 2, Pasig Industrial Park', '2025-06-15 10:10:00', 1),
(3, 'MirrorCraft PH', 'Josefa Lim', '+63-2-8111-0303', 'info@mirrorcraft.ph', 'Divisoria, Manila', '2025-05-20 11:20:00', 1),
(4, 'AluGlass Frames Co.', 'Daniel Reyes', '+63-2-8111-0404', 'contact@aluglass.ph', 'Mandaue Trade Center, Cebu', '2025-05-05 08:45:00', 1),
(5, 'Sealants & Brackets', 'Anna P.', '+63-2-8111-0505', 'support@sealbracket.ph', 'Dasmariñas, Cavite', '2025-04-30 14:00:00', 1);


INSERT OR IGNORE INTO raw_materials (_raw_material_id, material_name, description,  quantity, unit, created_at, is_deleted) VALUES
(1, 'Clear Tempered Glass', 'Tempered clear glass, cut-to-size', 1000, 'sqft', '2025-07-05 09:00:00', 0),
(2, 'Mirror Sheet (Polished)', 'Polished mirror sheet, 3mm',1000, 'sqft', '2025-07-06 09:05:00', 0),
(3, 'Aluminum Frame (per meter)', 'Aluminum extruded frame, suited for sliding door/window', 100,'meter', '2025-06-20 10:00:00', 0),
(4, 'Glass Shelf Bracket', 'Bracket set for glass shelves (pair)',100 ,'pcs', '2025-06-22 11:00:00', 0),
(5, 'Silicone Sealant (Black)', 'Neutral-cure silicone for glass installation, 300ml tube', 50, 'tube', '2025-06-25 12:00:00', 0);


INSERT OR IGNORE INTO items (_item_id, item_name, description, category, unit, created_at, is_deleted) VALUES
(1, 'Modular Cabinet', 'Modular storage cabinet with glass display door', 'furniture', 'pcs', '2025-08-20 09:00:00', 0),
(2, 'Sliding Door (Glass)', 'Sliding door with tempered glass panel and aluminum frame', 'doors', 'pcs', '2025-08-20 09:05:00', 0),
(3, 'Sliding Window (Glass)', 'Aluminum sliding window with clear glass', 'windows', 'pcs', '2025-08-20 09:10:00', 0),
(4, 'Wall Mirror', 'Tempered wall mirror, polished edges', 'glass', 'pcs', '2025-08-20 09:15:00', 0),
(5, 'Tempered Glass Panel', 'Tempered clear glass panel (cut-to-size)', 'glass', 'sqft', '2025-08-20 09:20:00', 0),
(6, 'Glass Shelf', 'Clear tempered glass shelf with drilled holes for brackets', 'glass', 'pcs', '2025-08-20 09:25:00', 0);


INSERT OR IGNORE INTO contracts (_contract_id, customer_name, contact_number, address, type_of_service, status, created_at, updated_at) VALUES
(1, 'Mendoza Bakery', '+63-917-000-1001', 'Brgy. San Juan, Makati', 'repair', 'in_progress', '2025-06-01 08:00:00', '2025-06-10 12:00:00'),
(2, 'Ace Hardware Branch 4', '+63-917-000-1002', 'Panay Ave., Quezon City', 'installation', 'completed', '2025-05-15 09:20:00', '2025-06-05 15:30:00'),
(3, 'Rizal College', '+63-917-000-1003', 'Rizal St., Pasig', 'installation', 'in_progress', '2025-07-02 10:00:00', '2025-07-10 11:00:00'),
(4, 'Lopez Clinic', '+63-917-000-1004', 'Mabini St., Manila', 'repair', 'picked_up', '2025-04-25 14:00:00', '2025-05-02 16:00:00'),
(5, 'Garcia Residence', '+63-917-000-1005', 'Brgy. Poblacion, Taguig', 'repair', 'completed', '2025-03-30 08:30:00', '2025-04-05 09:45:00');

INSERT INTO contract_details (_contract_id, _item_id, quantity, size, unit_price)
SELECT 1, 1, 1, '48x24 in', 22000.00
WHERE NOT EXISTS (
  SELECT 1 FROM contract_details WHERE _contract_id = 1 AND _item_id = 1 AND size = '48x24 in'
);

INSERT INTO contract_details (_contract_id, _item_id, quantity, size, unit_price)
SELECT 1, 6, 2, '24x8 in', 1500.00
WHERE NOT EXISTS (
  SELECT 1 FROM contract_details WHERE _contract_id = 1 AND _item_id = 6 AND size = '24x8 in'
);

INSERT INTO contract_details (_contract_id, _item_id, quantity, size, unit_price)
SELECT 2, 2, 3, '72x80 in', 18500.00
WHERE NOT EXISTS (
  SELECT 1 FROM contract_details WHERE _contract_id = 2 AND _item_id = 2 AND size = '72x80 in'
);

INSERT INTO contract_details (_contract_id, _item_id, quantity, size, unit_price)
SELECT 2, 3, 4, '48x48 in', 7600.00
WHERE NOT EXISTS (
  SELECT 1 FROM contract_details WHERE _contract_id = 2 AND _item_id = 3 AND size = '48x48 in'
);

INSERT INTO contract_details (_contract_id, _item_id, quantity, size, unit_price)
SELECT 3, 5, 10, '36x48 in', 1200.00
WHERE NOT EXISTS (
  SELECT 1 FROM contract_details WHERE _contract_id = 3 AND _item_id = 5 AND size = '36x48 in'
);

INSERT INTO contract_details (_contract_id, _item_id, quantity, size, unit_price)
SELECT 3, 4, 6, '24x36 in', 3200.00
WHERE NOT EXISTS (
  SELECT 1 FROM contract_details WHERE _contract_id = 3 AND _item_id = 4 AND size = '24x36 in'
);

INSERT INTO contract_details (_contract_id, _item_id, quantity, size, unit_price)
SELECT 4, 4, 2, '30x40 in', 3400.00
WHERE NOT EXISTS (
  SELECT 1 FROM contract_details WHERE _contract_id = 4 AND _item_id = 4 AND size = '30x40 in'
);

INSERT INTO contract_details (_contract_id, _item_id, quantity, size, unit_price)
SELECT 4, 6, 3, '18x10 in', 1200.00
WHERE NOT EXISTS (
  SELECT 1 FROM contract_details WHERE _contract_id = 4 AND _item_id = 6 AND size = '18x10 in'
);

INSERT INTO contract_details (_contract_id, _item_id, quantity, size, unit_price)
SELECT 5, 1, 1, '36x18 in', 15000.00
WHERE NOT EXISTS (
  SELECT 1 FROM contract_details WHERE _contract_id = 5 AND _item_id = 1 AND size = '36x18 in'
);

INSERT INTO contract_details (_contract_id, _item_id, quantity, size, unit_price)
SELECT 5, 5, 2, '12x24 in', 600.00
WHERE NOT EXISTS (
  SELECT 1 FROM contract_details WHERE _contract_id = 5 AND _item_id = 5 AND size = '12x24 in'
);

INSERT OR IGNORE INTO raw_materials_orders
(_order_id, _supplier_id, _employee_id, _order_number, discount_type, discount_value_php, vat_percent, status, status_updated_at, remarks)
VALUES
(1, 1, 2, 'ORD-GL-001', 'percent', 2.50, 12.00, 'acknowledged', '2025-08-05 09:15:00', 'Tempered glass for modular cabinet displays'),
(2, 2, 3, 'ORD-GL-002', 'fixed', 150.00, 12.00, 'pending', '2025-07-22 10:00:00', 'Mirror sheets for clinic and residence'),
(3, 3, 4, 'ORD-GL-003', 'none', 0.00, 12.00, 'audited', '2025-06-30 08:30:00', 'Aluminum frames and sliding hardware'),
(4, 4, 5, 'ORD-GL-004', 'fixed', 300.00, 12.00, 'rejected', '2025-05-10 13:00:00', 'Incorrect frame profile - supplier to revise'),
(5, 5, 6, 'ORD-GL-005', 'percent', 5.00, 12.00, 'acknowledged', '2025-04-28 09:30:00', 'Brackets & sealant for installations');


INSERT OR IGNORE INTO order_payments (_order_payment_id, _order_id, _created_at, reference_number, payment_method, amount_php) VALUES
(1, 1, '2025-08-06 11:00:00', 'PAY-GL-1001', 'bank_transfer', 20000.00),
(2, 2, '2025-07-23 12:15:00', 'PAY-GL-1002', 'gcash', 8000.00),
(3, 3, '2025-07-01 09:45:00', 'PAY-GL-1003', 'credit_card', 15000.00),
(4, 4, '2025-05-11 10:30:00', 'PAY-GL-1004', 'cash', 500.00),
(5, 5, '2025-04-29 14:20:00', 'PAY-GL-1005', 'bank_transfer', 1200.00);


INSERT INTO sales (_contract_id, sale_date, total_amount)
SELECT 1, '2025-06-10 12:30:00', 25000.00
WHERE NOT EXISTS (SELECT 1 FROM sales WHERE _contract_id = 1);

INSERT INTO sales (_contract_id, sale_date, total_amount)
SELECT 2, '2025-06-05 15:45:00', 85900.00
WHERE NOT EXISTS (SELECT 1 FROM sales WHERE _contract_id = 2);

INSERT INTO sales (_contract_id, sale_date, total_amount)
SELECT 3, '2025-07-10 11:15:00', 31200.00
WHERE NOT EXISTS (SELECT 1 FROM sales WHERE _contract_id = 3);

INSERT INTO sales (_contract_id, sale_date, total_amount)
SELECT 4, '2025-05-02 16:15:00', 10400.00
WHERE NOT EXISTS (SELECT 1 FROM sales WHERE _contract_id = 4);

INSERT INTO sales (_contract_id, sale_date, total_amount)
SELECT 5, '2025-04-05 10:00:00', 16200.00
WHERE NOT EXISTS (SELECT 1 FROM sales WHERE _contract_id = 5);

INSERT OR IGNORE INTO attendance (_attendance_id, _user_id, check_in, check_out) VALUES
(1, 2, '2025-08-18 08:05:00', '2025-08-18 17:00:00'),
(2, 3, '2025-08-18 08:10:00', '2025-08-18 16:45:00'),
(3, 4, '2025-08-18 07:50:00', '2025-08-18 16:30:00'),
(4, 5, '2025-08-18 08:00:00', NULL),
(5, 6, '2025-08-18 09:00:00', '2025-08-18 17:15:00');
