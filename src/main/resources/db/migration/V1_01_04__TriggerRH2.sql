CREATE OR REPLACE FUNCTION checkout()
  RETURNS TRIGGER AS $$
BEGIN  	
  	
  	UPDATE room
	SET history_id = null, status_id = 'CLE'
	WHERE room_id = NEW.room_id;
	
  RETURN NEW;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER trigger_rh2
AFTER UPDATE ON public.room_history
FOR EACH ROW EXECUTE PROCEDURE checkout();
