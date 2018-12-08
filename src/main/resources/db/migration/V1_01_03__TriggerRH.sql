CREATE OR REPLACE FUNCTION checkin()
  RETURNS TRIGGER AS $$
BEGIN
  UPDATE room
	SET history_id = NEW.id, status_id = 'ACT'
	WHERE room_id = NEW.room_id;
  RETURN NEW;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER trigger_rh
AFTER INSERT ON public.room_history
FOR EACH ROW EXECUTE PROCEDURE checkin();