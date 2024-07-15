ALTER TABLE payment_field RENAME COLUMN payemnt_info TO payment_info_id;

ALTER TABLE payment_field RENAME TO payemnt_fields;
ALTER TABLE payment_category RENAME TO payment_categories;
ALTER TABLE payment_field_choice RENAME TO payment_field_choices;